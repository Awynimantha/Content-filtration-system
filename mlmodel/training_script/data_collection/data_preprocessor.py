from pandas._libs.hashtable import mode
from configuration.config import *
import pandas as pd
import nltk
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
import nltk
import re
nltk.download('punkt_tab')
nltk.download('stopwords')
nltk.download('wordnet')

class DataPreProcessor:
    #self.data will act as the central buffer
    def getColoumn(self, columnBBC, columnALJAZ) -> None:
        numOfALJAZData = 500
        fileName = Configurations().INPUT_FILELOCATION_BBC 
        listDataBBC = pd.read_csv(fileName, names=["category", "filename", "title", "content" ], delimiter="\t")
        fileName = Configurations().INPUT_FILELOCATION_ALJAZ
        listDataALJAZ = pd.read_csv(fileName,  delimiter=",", encoding='utf-8')[:500]
        listDataALJAZ[columnALJAZ] = listDataALJAZ[columnALJAZ].apply(
            lambda x: re.sub(r'[\u00AD\u00A0\u200B]', '', str(x))
        )
        new_data = pd.DataFrame({"category": ["gazawar"] * 500})
        self.labeledData = pd.concat([listDataBBC, new_data], ignore_index=True)
        self.data = pd.concat([listDataBBC[columnBBC], listDataALJAZ[columnALJAZ]], ignore_index=True)

    def lowerCase(self) -> None:
        self.data = [string.lower() for string in self.data]   

    def tokenizeText(self) -> None:
        self.data = [word_tokenize(text) for text in self.data]

    def removeStopW(self) -> None:
        stopWordsSet = set(stopwords.words('english'))  
        modifiedList = []
        for string in self.data:
            tempList = [el for el in string if not  el in stopWordsSet]
            if len(tempList) == 0:
                continue
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
            if(label == "business" or label == "gazawar"):
                modifiedLables.append(1)
            else:
                modifiedLables.append(0)
        
        return modifiedLables

    def process(self, columnNameBBC, columnNameALJAZ) -> None:
        self.getColoumn(columnNameBBC, columnNameALJAZ)
        self.lowerCase()
        self.tokenizeText()
        self.removeStopW()
        self.lemmatize()
        self.joinWords()
        print(self.data)

    def fit(self, X = None, y = None):
        return self
    
    def transform(self, X = None):
        self.process("title", "headline") 
        labels = self.fixLabel()
        self.fixLabel()
        return self.data,labels 

   
