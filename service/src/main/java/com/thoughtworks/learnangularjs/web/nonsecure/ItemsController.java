package com.thoughtworks.learnangularjs.web.nonsecure;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.learnangularjs.domain.Book;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemsController {

    @RequestMapping(value = "/novelsforsale.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Book> getNovelsForSale() {
        return ImmutableList.of(
                new Book("Don Quixote", Arrays.asList("Miguel de Cervantes"), "The story of the gentle knight and his servant Sancho Panza has entranced readers for centuries.", "9780099469698", new BigDecimal("7.99")),
                new Book("Pilgrim's Progress", Arrays.asList("John Bunyan"), "The one with the Slough of Despond and Vanity Fair.", "9780141439716", new BigDecimal("7.19")),
                new Book("Robinson Crusoe", Arrays.asList("Daniel Defoe"), "The first English novel.", "9780141439822", new BigDecimal("5.59")),
                new Book("Gulliver's Travels", Arrays.asList("Jonathan Swift"), "A wonderful satire that still works for all ages, despite the savagery of Swift's vision.", "9781847490889", new BigDecimal("5.59")),
                new Book("Tom Jones", Arrays.asList("Henry Fielding"), "The adventures of a high-spirited orphan boy: an unbeatable plot.", "9781905716081", new BigDecimal("16.20")),
                new Book("Clarissa", Arrays.asList("Samuel Richardson"), "One of the longest novels in the English language, but unputdownable.", "9780395051641", new BigDecimal("17.99")),
                new Book("The Life and Opinions of Tristram Shandy, Gentleman", Arrays.asList("Laurence Sterne"), "One of the first bestsellers, dismissed by Dr Johnson as too fashionable for its own good.", "9780141439778", new BigDecimal("7.99")),
                new Book("Dangerous Liaisons", Arrays.asList("Pierre Choderlos de Laclos"), "An epistolary novel and a handbook for seducers: foppish, French, and ferocious.", "9780140449570", new BigDecimal("7.19")),
                new Book("Emma", Arrays.asList("Jane Austen"), "Near impossible choice between this and Pride and Prejudice. But Emma never fails to fascinate and annoy.", "9780141439587", new BigDecimal("5.59")),
                new Book("Frankenstein", Arrays.asList("Mary Shelley"), "Inspired by spending too much time with Shelley and Byron.", "9780141439471", new BigDecimal("5.59"))
        );
    }
}
