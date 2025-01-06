from data_collection.data_preprocessor import *
from feature_extraction.feature_extractor import FeatureExtractor
from pipeline.pipeline import *

pipeline =  Pipeline([
        DataPreProcessor(),
        FeatureExtractor()  
])

pipeline.execute()





