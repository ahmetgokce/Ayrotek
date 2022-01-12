docker compose up ile çalıştırabilirsiniz.

proje ayağa kalktıktan sonra, ilettiğim postman collection ile gerekli istekleri yapabilirsiniz.

signup ile kullanıcı yaratıp, bu kullanıcı ile login olabilirsiniz. Login servisi response olarak bir token dönmektedir.
Bu token'ı diğer servislere istek atmak için kullanmanız gerekmektedir.

createProduct; ürün oluşturmak için kullanılması gereken servistir.
updateProduct; bir ürünün bilglerini güncellemek için kullanılan servistir.
getProduct; id'sini belirttiğiniz ürünü response olarak dönen servistir.
getAllProduct; response olarak tüm ürünleri dönen servistir.

calculateTax; tax'i hesaplamak istediğiniz ürünün id'sini verdiğinizde ürün bilgileri ve tax'i response olarak dönecektir.