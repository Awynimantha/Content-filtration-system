class Pipeline:

    def __init__(self, handlers) :
        self.handlers = handlers
    
    def execute(self):
        X = None
        y = None
        for object in self.handlers:
            print("handlers")
            X, y = object.fit(X, y).transform()
