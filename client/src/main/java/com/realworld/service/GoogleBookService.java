package com.realworld.service;

import com.google.api.services.books.Books;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.realworld.exception.ClientBookNotFoundException;
import com.realworld.exception.ClientBooksNotFoundException;
import com.realworld.exception.ClientGeneralException;
import com.realworld.exception.ClientInvalidParameterException;
import com.realworld.mapper.GoogleBookConverter;
import com.realworld.model.GoogleBook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GoogleBookService {
    private final Books books;
    private final GoogleBookConverter bookConverter;

    public GoogleBookService(Books books, GoogleBookConverter bookConverter) {
        this.books = books;
        this.bookConverter = bookConverter;
    }

    public List<GoogleBook> getGoogleBooks(String search,
                                           String filter,
                                           int page,
                                           int size) {
        Volumes volumes = searchBooks(search, filter, page - 1, size);
        if (volumes != null && volumes.getItems() != null && !volumes.getItems().isEmpty())
            return bookConverter.convertToGoogleBooks(volumes);
        final String exceptionMessage = "Arama kriterlerine uygun kitap bulunamadı.";
        final String developerMessage = String.format("Kullanıcı tarafından %d sayfasında %d sonuç isteği oluşturulmuştur.", page, size);
        throw new ClientBooksNotFoundException(exceptionMessage, developerMessage, page, size);
    }
    public GoogleBook getGoogleBook(String bookId) {
        Volume volume = searchBook(bookId);
        if (volume != null)
            return bookConverter.convertToGoogleBook(volume);
        final String exceptionMessage = String.format("%s id'li kitap sistemde bulunamadı.", bookId);
        final String developerMessage = String.format("Kullanıcı google book api üzerinde %s kimliğe sahip kitaba ulaşmaya çalıştı.");
        throw new ClientBookNotFoundException(exceptionMessage, developerMessage);
    }

    // Client Search Method:
    private Volume searchBook(String bookId) {
        if (bookId != null && !bookId.trim().isEmpty()) {
            try {
                Books.Volumes.Get get = this.books.volumes().get(bookId);
                return get.execute();
            } catch (IOException ioException) {
                final String exceptionMessage = String.format("%s id'li kitap sistemde bulunamadı.", bookId);
                final String developerMessage = ioException.getMessage();
                throw new ClientGeneralException(exceptionMessage, developerMessage);
            }
        }
        final String exceptionMessage = "İstenilen kitap kimliği geçersiz girildi.";
        final String developerMessage = String.format("Kullanıcı tarafından %s kimliğine ait kitap istendi.", bookId);
        throw new ClientInvalidParameterException(exceptionMessage, developerMessage, bookId);
    }
    private Volumes searchBooks(String search,
                                String filter,
                                int page,
                                int size) {
        sizeValidation(size); // size control
        page = page > 0 ? page * size : 0;
        try {
            Books.Volumes.List bookList = this.books.volumes().list(search)
                    .setFilter(filter)
                    .setMaxResults((long) size)
                    .setStartIndex((long) page);
            return bookList.execute();
        } catch (IOException e) {
            final String exceptionMessage = "İstekte bulunurken beklenmedik bir hata ile karşılaşıldı.";
            final String developerMessage = e.getMessage();
            throw new ClientGeneralException(exceptionMessage, developerMessage);
        }
    }

    /**
     * Google Books API - maxResults:
     * Döndürülecek maksimum sonuç sayısı. Varsayılan değer 10, izin verilen maksimum değer ise 40'tır.
     *
     * @param size
     */
    private void sizeValidation(int size) {
        boolean response = size > 40 && size < 1 ? false : true;
        if (!response) {
            final String exceptionMessage = "Döndürülecek sonuç sayısı geçersiz girildi.";
            final String developerMessage = String.format("Kullanıcı tarafından %d sonuç istendi.", size);
            throw new ClientInvalidParameterException(exceptionMessage, developerMessage, String.valueOf(size));

        }
    }
}