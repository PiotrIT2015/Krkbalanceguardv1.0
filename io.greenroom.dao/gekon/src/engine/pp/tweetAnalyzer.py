from __future__ import print_function
import sys
from operator import add
from pyspark.sql import SparkSession
from pyspark.sql.types import *

spark = SparkSession.builder.master("local[*]").appName("Youtube_Data_Analysis").getOrCreate()