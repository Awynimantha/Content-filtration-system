from sklearn.model_selection import train_test_split
class ModelTrainer:
    def tranform(self, X, y): 
        self.X_train, self.X_test, self.y_train, self.y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    
    
