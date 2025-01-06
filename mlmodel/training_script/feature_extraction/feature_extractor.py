from sklearn.feature_extraction.text import TfidfVectorizer

class FeatureExtractor:

    def doTFIDF(self, stringList):
        vectorizer = TfidfVectorizer() 
        returnval = vectorizer.fit_transform(stringList)
        return returnval
        
    def fit(self, X, y=None):
        self.stringList = X          
        self.labels = y
        return self
        
    def transform (self):
        matrix = self.doTFIDF(self.stringList) 
        return matrix, self.labels 


