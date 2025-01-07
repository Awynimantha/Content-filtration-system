from data_collection.data_preprocessor import *
from feature_extraction.feature_extractor import FeatureExtractor
from model_train.model_trainer import ModelTrainer
from pipeline.pipeline import *
import pickle as pickle
from configuration.config import Configurations

train = False
if(train):
    pipeline =  Pipeline([
        DataPreProcessor(),
            FeatureExtractor(),
            ModelTrainer()
    ])
    pipeline.execute()


