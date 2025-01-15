from controllers.Controller import app
from configurations.configuration import Configurations
from service_discovery.eureka import Client

if __name__ == '__main__':
    Client() 
    app.run(debug=True, port = Configurations().PORT)
