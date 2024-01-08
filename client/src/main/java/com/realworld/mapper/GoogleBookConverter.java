package com.realworld.mapper;

import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volume.VolumeInfo.ImageLinks;
import com.google.api.services.books.model.Volume.SaleInfo;
import com.google.api.services.books.model.Volume.SaleInfo.ListPrice;
import com.google.api.services.books.model.Volume.SaleInfo.RetailPrice;
import com.google.api.services.books.model.Volumes;
import com.realworld.model.GoogleAuthor;
import com.realworld.model.GoogleBook;
import com.realworld.model.GoogleBookImage;
import com.realworld.model.GoogleSaleInfo;
import com.realworld.model.GoogleSalePrice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoogleBookConverter {
    public final GoogleBook convertToGoogleBook(Volume book) {
        final List<GoogleAuthor> googleAuthors = convertToGoogleAuthors(book.getVolumeInfo().getAuthors());
        final GoogleBookImage imageLinks = book.getVolumeInfo().getImageLinks() != null ? convertToGoogleBookImage(book.getVolumeInfo().getImageLinks()) : null;
        final GoogleSaleInfo saleInfo = convertToGoogleSaleInfo(book.getSaleInfo());
        GoogleBook googleBook = new GoogleBook.Builder()
                .bookId(book.getId())
                .title(book.getVolumeInfo().getTitle())
                .description(book.getVolumeInfo().getDescription())
                .publisher(book.getVolumeInfo().getPublisher())
                .pageCount(book.getVolumeInfo().getPageCount())
                .authors(googleAuthors)
                .imageLinks(imageLinks)
                .saleInfo(saleInfo)
                .pdfLink(book.getAccessInfo().getPdf().getAcsTokenLink())
                .build();
        return googleBook;
    }
    public final List<GoogleBook> convertToGoogleBooks(Volumes volumes){
        return volumes.getItems().stream()
                .map(this::convertToGoogleBook)
                .collect(Collectors.toList());
    }

    private List<GoogleAuthor> convertToGoogleAuthors(List<String> authors) {
        if (authors != null && !authors.isEmpty())
            return authors.stream()
                    .map(k -> {
                        String[] author = k.split(" ");
                        String name = "";
                        String surname = "";
                        if(author.length > 2 && author.length <= 3){
                            name = author[0].concat(" ").concat(author[1]);
                            surname = author[2];
                        } else if (author.length > 3) {
                            name = author[0].concat(" ").concat(author[1].concat(" ")).concat(author[2]);
                            surname = author[3];
                        } else if (author.length == 2) {
                            name = author[0];
                            surname = author[1];
                        } else
                            name = author[0];
                        return new GoogleAuthor.Builder()
                                .name(name)
                                .surname(surname)
                                .build();
                    }).collect(Collectors.toList());
        return null;
    }
    private GoogleBookImage convertToGoogleBookImage(ImageLinks imageLinks) {
        return new GoogleBookImage.Builder()
                .smallThumbnail(imageLinks.getSmallThumbnail())
                .thumbnail(imageLinks.getThumbnail())
                .build();
    }
    private GoogleSaleInfo convertToGoogleSaleInfo(SaleInfo saleInfo) {
        final GoogleSalePrice listPrice = saleInfo.getListPrice() != null ? convertToGoogleListPrice(saleInfo.getListPrice()) : null;
        final GoogleSalePrice retailPrice = saleInfo.getRetailPrice() != null ? convertToGoogleRetailPrice(saleInfo.getRetailPrice()) : null;
        return new GoogleSaleInfo.Builder()
                .country(saleInfo.getCountry())
                .salebility(saleInfo.getSaleability())
                .isEbook(saleInfo.getIsEbook())
                .listPrice(listPrice)
                .retailPrice(retailPrice)
                .buyLink(saleInfo.getBuyLink())
                .build();
    }
    private GoogleSalePrice convertToGoogleListPrice(ListPrice listPrice) {
        return new GoogleSalePrice.Builder()
                .amount(listPrice.getAmount() != null ? listPrice.getAmount() : 0.0)
                .currencyCode(listPrice.getCurrencyCode() != null ? listPrice.getCurrencyCode() : "TRY")
                .build();
    }
    private GoogleSalePrice convertToGoogleRetailPrice(RetailPrice retailPrice) {
        return new GoogleSalePrice.Builder()
                .amount(retailPrice.getAmount() != null ? retailPrice.getAmount() : 0.0)
                .currencyCode(retailPrice.getCurrencyCode() != null ? retailPrice.getCurrencyCode() : "TRY")
                .build();
    }
}