package engine.pp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.aarboard.nextcloud.api.utils.WebdavInputStream;
import org.aarboard.nextcloud.api.ServerConfig;
import org.aarboard.nextcloud.api.exception.NextcloudApiException;

import org.apache.http.client.utils.URIBuilder;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

public class nextcloudServices {
    private static final Logger LOG = LoggerFactory.getLogger(healthService.class);

    private final ServerConfig _serverConfig;

    public nextcloudServices(ServerConfig serverConfig) {
        _serverConfig = serverConfig;
    }

    private static final String ADMINPP_BASE_PATH = "remote.php/adminpp/";

    protected String buildWebdavPath(String remotePath)
    {
        URIBuilder uB= new URIBuilder()
                .setScheme(_serverConfig.isUseHTTPS() ? "https" : "http")
                .setHost(_serverConfig.getServerName())
                .setPort(_serverConfig.getPort())
                .setPath(
                        _serverConfig.getSubpathPrefix() == null ?
                                ADMINPP_BASE_PATH + remotePath :
                                _serverConfig.getSubpathPrefix()+ "/" + ADMINPP_BASE_PATH + remotePath
                );
        return uB.toString();
    }

    protected Sardine buildAuthSardine()
    {
        Sardine sardine = SardineFactory.begin();
        sardine.setCredentials(_serverConfig.getUserName(), _serverConfig.getPassword());
        sardine.enablePreemptiveAuthentication(_serverConfig.getServerName());

        return sardine;
    }

    public void uploadFile(File localSource, String remotePath) {
        String path = buildWebdavPath(remotePath);
        Sardine sardine = buildAuthSardine();

        try
        {
            sardine.put(path, localSource, null, true);
        } catch (IOException e)
        {
            throw new NextcloudApiException(e);
        }
        finally
        {
            try
            {
                sardine.shutdown();
            }
            catch(Exception ex2)
            {
                LOG.warn("Error in sardine shutdown", ex2);
            }
        }
    }

    public void uploadFile(InputStream inputStream, String remotePath) {
        uploadFile(inputStream, remotePath, true);
    }

    public void uploadFile(InputStream inputStream, String remotePath, boolean continueHeader) {
        String path = buildWebdavPath(remotePath);

        Sardine sardine = buildAuthSardine();

        try
        {
            sardine.put(path, inputStream, null, continueHeader);
        } catch (IOException e)
        {
            throw new NextcloudApiException(e);
        }
        finally
        {
            try
            {
                sardine.shutdown();
            }
            catch(Exception ex2)
            {
                LOG.warn("Error in sardine shutdown", ex2);
            }
        }
    }


    private long convertStringToLong(String number)
    {
        if (number == null || number.equals(""))
        {
            return 0;
        }
        else
        {
            return Long.parseLong(number);
        }
    }
}
