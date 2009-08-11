/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.offer.domain;

import java.util.ArrayList;
import java.util.List;

import org.broadleafcommerce.util.money.Money;

public class OrderItemOfferImpl implements OrderItemOffer {

    protected Offer offer;
    protected List<CandidateItemOffer> candidateItemOffers = new ArrayList<CandidateItemOffer> ();
    protected Money totalDiscount = new Money(0);

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public List<CandidateItemOffer> getCandidateItemOffers() {
        return candidateItemOffers;
    }

    public void addCandidateItemOffer(CandidateItemOffer candidateItemOffer) {
        candidateItemOffers.add(candidateItemOffer);
        totalDiscount = totalDiscount.add(candidateItemOffer.getDiscountAmount().multiply(candidateItemOffer.getOrderItem().getQuantity()));
    }

    public Money getTotalDiscount() {
        return totalDiscount;
    }

    public int getPriority() {
        return offer.getPriority();
    }

}
