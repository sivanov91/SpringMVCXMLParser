package ru.myproject.domain;

import java.math.BigDecimal;

/**
 * Created by dellix on 30.03.15.
 */
public class Result {

    public BigDecimal sumAllOrderPrice = new BigDecimal(0);
    public String customerWidthMaxSumOrdersPrice = "";
    public BigDecimal sumMaxOrderPrice = new BigDecimal(0);
    public BigDecimal sumMinOrderPrice = new BigDecimal(0);
    public int orderCount = 0;
    public BigDecimal avgSumOrderPrice = new BigDecimal(0);

    public String customerSumOrderPriceMoreN = "";

    public BigDecimal getSumAllOrderPrice() {
        return sumAllOrderPrice;
    }

    public void setSumAllOrderPrice(BigDecimal sumAllOrderPrice) {
        this.sumAllOrderPrice = sumAllOrderPrice;
    }

    public String getCustomerWidthMaxSumOrdersPrice() {
        return customerWidthMaxSumOrdersPrice;
    }

    public void setCustomerWidthMaxSumOrdersPrice(String customerWidthMaxSumOrdersPrice) {
        this.customerWidthMaxSumOrdersPrice = customerWidthMaxSumOrdersPrice;
    }

    public BigDecimal getSumMaxOrderPrice() {
        return sumMaxOrderPrice;
    }

    public void setSumMaxOrderPrice(BigDecimal sumMaxOrderPrice) {
        this.sumMaxOrderPrice = sumMaxOrderPrice;
    }

    public BigDecimal getSumMinOrderPrice() {
        return sumMinOrderPrice;
    }

    public void setSumMinOrderPrice(BigDecimal sumMinOrderPrice) {
        this.sumMinOrderPrice = sumMinOrderPrice;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getAvgSumOrderPrice() {
        return avgSumOrderPrice;
    }

    public void setAvgSumOrderPrice(BigDecimal avgSumOrderPrice) {
        this.avgSumOrderPrice = avgSumOrderPrice;
    }

    public String getCustomerSumOrderPriceMoreN() {
        return customerSumOrderPriceMoreN;
    }

    public void setCustomerSumOrderPriceMoreN(String customerSumOrderPriceMoreN) {
        this.customerSumOrderPriceMoreN = customerSumOrderPriceMoreN;
    }
}
