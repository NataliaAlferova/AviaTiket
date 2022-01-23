package ru.netology.domain;

public class Offer implements Comparable <Object> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int flyTime;

    public Offer() {
    }

    public Offer(int id, int price, String from, String to, int flyTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(int flyTime) {
        this.flyTime = flyTime;
    }

    @Override
    public int compareTo(Object o) {
        Offer t = (Offer) o;
        return this.price - t.price;
    }
}
