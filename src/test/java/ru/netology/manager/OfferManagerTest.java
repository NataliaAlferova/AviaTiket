package ru.netology.manager;

import ru.netology.domain.Offer;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OfferManagerTest {
    OfferManager tiketManager = new OfferManager(new Repository(new Offer[]{}));
    Offer offer1 = new Offer(01, 10900, "DME", "ULV", 70);
    Offer offer2 = new Offer(02, 7300, "LED", "SVO", 55);
    Offer offer3 = new Offer(03, 7100, "DME", "BER", 155);
    Offer offer4 = new Offer(04, 5400, "DME", "ULV", 70);
    Offer offer5 = new Offer(05, 7100, "DME", "BER", 155);


    @Test
    public void shouldSortByPrice() {
        tiketManager.add(offer1);
        tiketManager.add(offer2);
        tiketManager.add(offer3);
        tiketManager.add(offer4);

        Offer[] expected = {offer4, offer1};
        Offer[] actual = tiketManager.searchByFromAndTo("DME", "ULV");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceNoResult() {
        tiketManager.add(offer1);
        tiketManager.add(offer2);
        tiketManager.add(offer3);
        tiketManager.add(offer4);

        Offer[] expected = {};
        Offer[] actual = tiketManager.searchByFromAndTo("BER", "ULV");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceOneResult() {
        tiketManager.add(offer1);
        tiketManager.add(offer2);
        tiketManager.add(offer3);
        tiketManager.add(offer4);

        Offer[] expected = {offer2};
        Offer[] actual = tiketManager.searchByFromAndTo("LED", "SVO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceEqualsPrice() {
        tiketManager.add(offer1);
        tiketManager.add(offer2);
        tiketManager.add(offer3);
        tiketManager.add(offer4);
        tiketManager.add(offer5);

        Offer[] expected = {offer3,offer5};
        Offer[] actual = tiketManager.searchByFromAndTo("DME", "BER");

        assertArrayEquals(expected, actual);
    }
}