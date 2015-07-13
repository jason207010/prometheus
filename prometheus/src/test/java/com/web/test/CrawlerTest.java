package com.web.test;

import org.junit.Test;

/**
 * @author jayson   2015-07-10-20:53
 * @since v1.0
 */
public class CrawlerTest {
    @Test
    public void test(){
        A a = new A();
        B b = new B();
        int c = b.getB();
    }
    class A{
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }
    class B{
        Integer b;

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }
    }
}
