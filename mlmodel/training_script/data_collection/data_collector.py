from configuration.config import *
import pandas as pd
class DataCollector:
    def fit(self, X = None, y = None):
        self.fileName = Configurations().INPUT_FILELOCATION  
        return self

    def transform(self, X = None):
        data = pd.read_csv(self.fileName, names=["category", "filename", "title", "content" ], delimiter="\t")
        return data[["category", "filename"]]

