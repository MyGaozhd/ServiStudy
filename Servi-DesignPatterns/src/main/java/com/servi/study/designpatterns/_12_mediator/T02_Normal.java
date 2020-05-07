package com.servi.study.designpatterns._12_mediator;

/*
 *代码有bug 只代表意思
 */
public class T02_Normal {

    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        Stock stock = new Stock();
        Sale sale = new Sale();

        //采购商品
        purchase.doPurchase();
        //库存满了
        stock.full();
        //打折销售
        sale.offSale();

    }

    /**
     * 采购管理
     */
    static class Purchase {
        Stock stock = new Stock();
        Sale sale = new Sale();

        //采购
        void doPurchase() {
            //执行采购
            System.out.println("采购管理，执行采购");
            //采购管理增加库存
            stock.inCrease();
            //去销售
            sale.doSale();
        }

        //停止采购
        void stopPurchase() {
            //执行采购
            System.out.println("采购管理，停止采购");
        }
    }

    static class Stock {
        Purchase purchase = new Purchase();
        Sale sale = new Sale();

        //增加库存
        void inCrease() {
            System.out.println("库存管理，增加库存");
        }

        //减少库存
        void deCrease() {
            System.out.println("库存管理，减少库存");
        }

        //库存满了
        void full() {
            System.out.println("库存管理，库存满了");
            //停止采购
            purchase.stopPurchase();
            //打折销售
            sale.offSale();
        }
    }

    static class Sale {

        Stock stock = new Stock();

        //去销售
        void doSale() {
            System.out.println("销售管理，正常销售");
            stock.deCrease();
        }

        //打折销售
        void offSale() {
            System.out.println("销售管理，打折销售");
            stock.deCrease();
        }
    }
}
