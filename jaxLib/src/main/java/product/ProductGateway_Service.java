package product;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-10T22:09:34.231+03:00
 * Generated source version: 3.4.5
 *
 */
@WebServiceClient(name = "ProductGateway",
                  wsdlLocation = "file:/C:/Users/edyso/Desktop/MPT/jaxLib/src/main/resources/wsdl/product.wsdl",
                  targetNamespace = "http://product")
public class ProductGateway_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://product", "ProductGateway");
    public final static QName ProductGatewaySoap11 = new QName("http://product", "ProductGatewaySoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/edyso/Desktop/MPT/jaxLib/src/main/resources/wsdl/product.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProductGateway_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/edyso/Desktop/MPT/jaxLib/src/main/resources/wsdl/product.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProductGateway_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProductGateway_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductGateway_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ProductGateway_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ProductGateway_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ProductGateway_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ProductGateway
     */
    @WebEndpoint(name = "ProductGatewaySoap11")
    public ProductGateway getProductGatewaySoap11() {
        return super.getPort(ProductGatewaySoap11, ProductGateway.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductGateway
     */
    @WebEndpoint(name = "ProductGatewaySoap11")
    public ProductGateway getProductGatewaySoap11(WebServiceFeature... features) {
        return super.getPort(ProductGatewaySoap11, ProductGateway.class, features);
    }

}
