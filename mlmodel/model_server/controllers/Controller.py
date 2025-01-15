from flask import Flask, request, jsonify
import json
from mlmodel.model import ModelServer
app = Flask(__name__)

@app.route('/v1/predict', methods = ['POST'])
def predict():
    data = request.get_json()
    result = {}
    print(data)
    for key,value in data.items():
        classifer = ModelServer() 
        label = classifer.predict(key)
        if(label == 1):
            result[key] = value
    return jsonify(result)
