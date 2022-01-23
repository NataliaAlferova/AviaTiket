package ru.netology.manager;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Offer;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class OfferManager {
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public OfferManager() {
    }

    public OfferManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Offer offer) {
        repository.save(offer);
    }

    public Offer[] searchByFromAndTo(String from, String to) {
        Offer[] tmpResult = new Offer[0];
        Offer[] result = new Offer[0];
        for (Offer offer : repository.showAll()) {
            if (matches(offer, from)) {
                Offer[] tmp = new Offer[tmpResult.length + 1];
                System.arraycopy(tmpResult, 0, tmp, 0, tmpResult.length);
                tmp[tmp.length - 1] = offer;
                tmpResult = tmp;
            }
        }

        for (Offer offer : tmpResult) {
            if (matches(offer, to)) {
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Offer offer, String search) {
        if (offer.getFrom().contains(search) || offer.getTo().contains(search)) {
            return true;
        }
        return false;
    }
}

