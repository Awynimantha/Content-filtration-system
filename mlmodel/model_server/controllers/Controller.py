from flask import Flask, request, jsonify
from mlmodel.model import ModelServer
app = Flask(__name__)

@app.route('/v1/predict', methods = ['POST'])
def predict():
    data = request.get_json()

    if not data or 'title' not in data:
        return jsonify({"error": "Missing title"})
    classifer = ModelServer() 

    label = classifer.predict(data['title'])
    if(label == 0):
        label = "0"
    else:
        label = "1"
    return jsonify({"label": label})
