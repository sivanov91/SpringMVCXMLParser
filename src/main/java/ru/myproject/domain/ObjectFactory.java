
package ru.myproject.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.myproject.domain package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Customers_QNAME = new QName("", "customers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.myproject.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomersType }
     * 
     */
    public CustomersType createCustomersType() {
        return new CustomersType();
    }

    /**
     * Create an instance of {@link PositionsType }
     * 
     */
    public PositionsType createPositionsType() {
        return new PositionsType();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link OrderType }
     * 
     */
    public OrderType createOrderType() {
        return new OrderType();
    }

    /**
     * Create an instance of {@link PositionType }
     * 
     */
    public PositionType createPositionType() {
        return new PositionType();
    }

    /**
     * Create an instance of {@link OrdersType }
     * 
     */
    public OrdersType createOrdersType() {
        return new OrdersType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "customers")
    public JAXBElement<CustomersType> createCustomers(CustomersType value) {
        return new JAXBElement<CustomersType>(_Customers_QNAME, CustomersType.class, null, value);
    }

}
