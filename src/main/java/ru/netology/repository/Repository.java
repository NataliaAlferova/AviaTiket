package ru.netology.repository;

import ru.netology.domain.Offer;
import ru.netology.domain.NotFoundException;

public class Repository {

    private Offer[] offers = new Offer[0];

    public Repository(Offer[] items) {
        this.offers = items;
    }

    public Repository() {
    }

    public void save(Offer offer) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        for (int i = 0; i < offers.length; i++) {
            tmp[i] = offers[i];
        }
        tmp[tmp.length - 1] = offer;
        offers = tmp;
    }

    public Offer[] showAll() {
        return offers;
    }

    public Offer findById(int id) {
        for (Offer item : offers) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new NotFoundException("Element with id:" + id + " not found");
    }

    public Offer[] removeById(int id) {
        findById(id);
        int length = offers.length - 1;
        Offer[] tmp = new Offer[length];
        int index = 0;
        for (Offer item : offers) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        offers = tmp;
        return offers;
    }

    public Offer[] getItems() {

        return offers;
    }

    public void setItems(Offer[] items) {

        this.offers = items;
    }

}
