from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, classification_report
from sklearn.svm import SVC
import numpy as np
import pickle as pickle
from configuration.config import Configurations

class ModelTrainer:

    def transform(self): 
        self.X_train, self.X_test, self.y_train, self.y_test = train_test_split(self.X, self.y, test_size=0.2, random_state=42)
        svm_model = SVC(kernel = "linear", random_state = 42)
        svm_model.fit(self.X_train, self.y_train)
        y_pred = svm_model.predict(self.X_test)
        outPutFile = Configurations().MODEL_OUTPUT
        with open(outPutFile, 'wb') as model_file:
            pickle.dump(svm_model, model_file) 
        accuracy = accuracy_score(self.y_test, y_pred)
        print(f"Accuracy: {accuracy:.2f}")

        #Detailed classification report
        print("Classification Report:")
        print(classification_report(self.y_test, y_pred))
        return 0,0
    
    def fit(self, X = None , y = None):
        self.X = X
        self.y = y
        return self
    
