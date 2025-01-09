from sklearn.feature_extraction.text import TfidfVectorizer
import numpy as np
import pickle as pickle

from configuration.config import Configurations

class FeatureExtractor:

    def doTFIDF(self, stringList):
        vectorizer = TfidfVectorizer(stop_words=None) 
        returnval = vectorizer.fit_transform(stringList)
        with open(Configurations().TFIDF_MATRIX_OUTPUT, 'wb') as tfidf_file:
            pickle.dump(vectorizer, tfidf_file)
        return returnval
        
    def fit(self, X, y=None):
        self.stringList = X          
        self.labels = y
        return self
        
    def transform (self):
        matrix = self.doTFIDF(self.stringList)  
        return matrix, self.labels 


