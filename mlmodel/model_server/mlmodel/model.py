import pickle as pickle
from configurations.configuration import Configurations
import pickle as pickle 
from sklearn.feature_extraction.text import TfidfVectorizer  
from sklearn.svm import SVC  
from configurations.configuration import Configurations  


class ModelServer:
    def predict(self, string:str):
        model = None
        tfidf = None
        with open(Configurations().MODEL_OUTPUT, 'rb') as svm_model:
            model = pickle.load(svm_model)
            with open(Configurations.TFIDF_MATRIX_OUTPUT, 'rb') as tfidf_file:
                tfidf = pickle.load(tfidf_file)
            vector = tfidf.transform([string])
        return model.predict(vector)



