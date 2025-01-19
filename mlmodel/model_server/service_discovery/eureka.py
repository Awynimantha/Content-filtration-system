from configurations.configuration import Configurations
import py_eureka_client.eureka_client as eureka_client


class Client:

    def __init__(self):
        self.client = eureka_client; 
        eureka_client.init(eureka_server="http://localhost:9082/eureka/",
                                            app_name="mlservice",
                                            instance_ip="127.0.0.1", 
                                            instance_port=Configurations().PORT)
                
    
