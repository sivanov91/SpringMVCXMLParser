package ru.myproject.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import ru.myproject.domain.*;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellix on 31.03.15.
 */

@Controller
public class MainController implements ApplicationContextAware {

    ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public Result calcOrders(CustomersType customers, BigDecimal sumOrderPriceN) {

        Result result = new Result();

        BigDecimal tmpSumMaxOrderPrice = new BigDecimal(0);
        BigDecimal tmpSumMinOrderPrice = null;
        String tmpCustomerWidthMaxSumOrderPrice = "";

        BigDecimal tmpMaxSumAllCustomerOrders = new BigDecimal(0);
        List<String> customerSumOrderPriceMoreNList = new ArrayList<String>();



        List<CustomerType> customersTypeList = customers.getCustomer();

        for (CustomerType customer : customersTypeList) {

            BigDecimal sumAllCustomerOrders = new BigDecimal(0);

            for (OrderType order : customer.getOrders().getOrder()) {

                BigDecimal orderSumPrice = new BigDecimal(0);

                for (PositionType position : order.getPositions().getPosition()) {
                    result.sumAllOrderPrice = result.sumAllOrderPrice.add((position.getPrice()).multiply(new BigDecimal(position.getCount())));
                    orderSumPrice = orderSumPrice.add((position.getPrice()).multiply(new BigDecimal(position.getCount())));
                }

                //calc max orders and customer with max order sum
                if (tmpSumMaxOrderPrice.compareTo(orderSumPrice) < 0)
                    tmpSumMaxOrderPrice = orderSumPrice;

                if (tmpSumMinOrderPrice == null)
                    tmpSumMinOrderPrice = orderSumPrice;
                else if (tmpSumMinOrderPrice.compareTo(orderSumPrice) > 0)
                    tmpSumMinOrderPrice = orderSumPrice;

                sumAllCustomerOrders = sumAllCustomerOrders.add(orderSumPrice);
                result.orderCount++;
            }

            if (tmpMaxSumAllCustomerOrders.compareTo(sumAllCustomerOrders) < 0) {
                tmpMaxSumAllCustomerOrders = sumAllCustomerOrders;
                tmpCustomerWidthMaxSumOrderPrice = customer.getName();
            }

            if (sumOrderPriceN != null && sumOrderPriceN.compareTo(sumAllCustomerOrders) < 0){
                customerSumOrderPriceMoreNList.add(customer.getName());
            }

        }

        result.customerWidthMaxSumOrdersPrice = tmpCustomerWidthMaxSumOrderPrice;
        result.sumMaxOrderPrice = tmpSumMaxOrderPrice;
        result.sumMinOrderPrice = tmpSumMinOrderPrice;
        result.avgSumOrderPrice = result.sumAllOrderPrice.divide(new BigDecimal(result.orderCount));

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for(String customer : customerSumOrderPriceMoreNList){
            sb.append(prefix);
            sb.append(customer);
            prefix = ", ";
        }
        if (!sb.toString().equals(""))
            result.customerSumOrderPriceMoreN = sb.toString();
        else
            result.customerSumOrderPriceMoreN = "No Found.";

        return result;
    }

    public Result calcOrders(CustomersType customers){
        return calcOrders(customers, null);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String provideUploadInfo(Model model) {

        UploadFile uploadFile = new UploadFile();
        uploadFile.setName("Test");

        model.addAttribute("uploadFile", uploadFile);

        model.addAttribute("errorMessage", "");

        return "fileupload";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String handleFileUpload(@ModelAttribute("uploadFile") UploadFile uploadFile, Model model) {

        String errorMessage = "";

        MultipartFile file = uploadFile.getFile();

        if (!file.isEmpty()) {
            try {

                Unmarshaller unmarshaller = (Unmarshaller) context.getBean("jaxbMarshallerBean");

                CustomersType customers = (CustomersType) unmarshaller.unmarshal(new StreamSource(file.getInputStream()));

                Result result;
                if (uploadFile.getSumOrderPriceN().equals(""))
                    result = calcOrders(customers);
                else {

                    BigDecimal SumOrderPriceN = new BigDecimal(uploadFile.getSumOrderPriceN());
                    result = calcOrders(customers, SumOrderPriceN);
                }


                model.addAttribute("result", result);
                errorMessage = "";


            } catch (NumberFormatException nfe){
                errorMessage = "Incorect Format N";
            } catch (IOException  ioe) {
                errorMessage = ioe.getMessage();
            } catch (Exception e) {
                errorMessage = e.getMessage();
            }

        } else {
            errorMessage = "Fild file is empty.";
        }

        model.addAttribute("errorMessage", errorMessage);

        if (!errorMessage.equals("")){
            return "fileupload";
        }


        return "result";

    }

}
