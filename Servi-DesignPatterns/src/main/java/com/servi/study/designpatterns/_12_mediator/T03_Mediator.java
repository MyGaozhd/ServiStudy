package com.servi.study.designpatterns._12_mediator;

import java.awt.event.TextEvent;

/*
 *代码有bug 只代表意思
 */
public class T03_Mediator {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Purchase purchase = mediator.getPurchase();
        Stock stock = mediator.getStock();
        Sale sale = mediator.getSale();

        //采购商品
        purchase.doPurchase();
        //库存满了
        stock.full();
        //打折销售
        sale.offSale();

    }

    static interface AbstractMediator {

        public abstract void execute(String did);
    }

    static class Mediator implements AbstractMediator {

        Purchase purchase = new Purchase(this);
        Stock stock = new Stock(this);
        Sale sale = new Sale(this);

        public Purchase getPurchase() {
            return purchase;
        }

        public Stock getStock() {
            return stock;
        }

        public Sale getSale() {
            return sale;
        }

        @Override
        public void execute(String did) {

            if (did.equals("doSale")) {
                stock.deCrease();
            }

            if (did.equals("doPurchase")) {
                stock.inCrease();
            }

            if (did.equals("full")) {
                purchase.stopPurchase();
                sale.offSale();
            }

            if (did.equals("doPurchase")) {
                sale.doSale();
                stock.inCrease();
            }

        }


    }

    /**
     * 采购管理
     */
    static class Purchase {

        private AbstractMediator mediator;

        public Purchase(AbstractMediator mediator) {
            this.mediator = mediator;
        }

        //采购
        void doPurchase() {
            //执行采购
            System.out.println("采购管理，执行采购");

            mediator.execute("doPurchase");
        }

        //停止采购
        void stopPurchase() {
            //执行采购
            System.out.println("采购管理，停止采购");
        }
    }

    static class Stock {

        private AbstractMediator mediator;

        public Stock(AbstractMediator mediator) {
            this.mediator = mediator;
        }

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

            mediator.execute("full");
        }
    }

    static class Sale {

        private AbstractMediator mediator;

        public Sale(AbstractMediator mediator) {
            this.mediator = mediator;
        }

        //去销售
        void doSale() {
            System.out.println("销售管理，正常销售");
            mediator.execute("dosale");
        }

        //打折销售
        void offSale() {
            System.out.println("销售管理，打折销售");
            mediator.execute("offSale");
        }
    }
}
