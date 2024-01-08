package com.realworld.enumeration;

/**
 *  Bu sınıf, Google e-Kitap aramaları için çeşitli filtre seçeneklerini içerir.
 *  <p>
 *  Filtre Seçenekleri:
 *  <ul>
 *      <li><b>Partial:</b> Metnin en az bir kısmının önizlenebilir olduğu sonuçları döndürür.</li>
 *      <li><b>Full:</b> Yalnızca metnin tamamının görüntülenebilir olduğu sonuçları döndürür.</li>
 *      <li><b>Free-Ebooks:</b> Yalnızca ücretsiz Google e-Kitaplar olan sonuçları döndürür.</li>
 *      <li><b>Paid-Ebooks:</b> Yalnızca fiyatı olan Google e-Kitaplar olan sonuçları döndürür.</li>
 *      <li><b>Ebooks:</b> Yalnızca ücretli veya ücretsiz Google e-Kitaplar olan sonuçları döndürür.
 *       E-Kitap olmayanlara örnek olarak sınırlı önizlemede sunulan ve satışa sunulmayan yayıncı içeriği
 *       veya dergiler verilebilir.</li>
 *  </ul>
 *  </p>
 */
public enum FilterKeyword {
    PARTIAL("partial"),
    FULL("full"),
    FREE_EBOOKS("free-ebooks"),
    PAID_EBOOKS("paid-ebooks"),
    EBOOKS("ebooks");

    private final String filter;

    FilterKeyword(String filter){
        this.filter = filter;
    }

    public String getFilter(){
        return this.filter;
    }
}