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

model = None
tfidf = None
with open(Configurations().MODEL_OUTPUT, 'rb') as svm_model:
    model = pickle.load(svm_model)


with open(Configurations.TFIDF_MATRIX_OUTPUT, 'rb') as tfidf_file:
    tfidf = pickle.load(tfidf_file)

vector = tfidf.transform(["US warplane shot down in Red Sea 'friendly fire' incident"])
print(model.predict(vector))


