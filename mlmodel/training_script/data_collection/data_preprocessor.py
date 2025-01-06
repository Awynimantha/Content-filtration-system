from pandas._libs.hashtable import mode
from configuration.config import *
import pandas as pd
import nltk
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
import nltk
nltk.download('punkt_tab')
nltk.download('stopwords')
nltk.download('wordnet')

class DataPreProcessor:
    #self.data will act as the central buffer
    def getColoumn(self, column) -> None:
        listData = pd.read_csv(self.fileName, names=["category", "filename", "title", "content" ], delimiter="\t")
        columns = [column]+["category"]
        self.labeledData = listData[columns]
        self.data = listData[[column]].values

    def lowerCase(self) -> None:
        self.data = [el.lower() for string in self.data for el in string ]   

    def tokenizeText(self) -> None:
        self.data = [word_tokenize(text) for text in self.data]

    def removeStopW(self) -> None:
        stopWordsSet = set(stopwords.words('english'))  
        modifiedList = []
        for string in self.data:
            tempList = [el for el in string if not  el in stopWordsSet]
            modifiedList = modifiedList + [tempList]
        self.data = modifiedList

    def lemmatize(self) -> None:
        modifiedList = []
        for string in self.data: 
            tempData = [WordNetLemmatizer().lemmatize(text) for text in string]
            modifiedList = modifiedList + [tempData]
        self.data = modifiedList

    def joinWords(self):
        modifiedList = []
        for string in self.data:
            tempData = " ".join(string)
            modifiedList = modifiedList + [tempData]
        self.data = modifiedList

    def fixLabel(self):
        labels = self.labeledData['category'].values
        modifiedLables = []
        for label in labels:
            if(label == "business"):
                modifiedLables.append(1)
            else:
                modifiedLables.append(0)
        
        return modifiedLables

    def process(self, columnName) -> None:
        self.getColoumn(columnName) #process only title column
        self.lowerCase()
        self.tokenizeText()
        self.removeStopW()
        self.lemmatize()
        self.joinWords()

    def fit(self, X = None, y = None):
        self.fileName = Configurations().INPUT_FILELOCATION  
        return self
    
    def transform(self, X = None):
        self.process("title") 
        labels = self.fixLabel()
        self.fixLabel()
        return self.data,labels 

   
