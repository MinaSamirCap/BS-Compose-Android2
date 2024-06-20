package com.sample.compose_bs_android2.mine.pdf

data class Invoice(
    val number: Long,
    val price: Float,
    val link: String,
    val date: String,
    val from: PersonInfo,
    val to: PersonInfo,
    val products: List<Product>,
    val signatureUrl: String? = null
)

data class PersonInfo(
    val name: String,
    val address: String
)

data class Product(
    val description: String,
    val rate: Float,
    val quantity: Int
)

val sampleInvoice = Invoice(
    number = 7877859L,
    price = 885.0f,
    link = "https://www.google.com",
    date = "Tue 4th Aug, 2020",
    from = PersonInfo(
        name = "Leslie Alexander",
        address = "2972 Westheimer Rd. Santa Ana, IIlinois 85486"
    ),
    to = PersonInfo(
        name = "Marvin McKinney",
        address = "2972 Westheimer Rd. Santa Ana, IIlinois 85486"
    ),
    listOf(
        Product(
            description = "Dashboard Design",
            rate = 779.58f,
            quantity = 1
        ),
        Product(
            description = "Logo Design",
            rate = 106.58f,
            quantity = 2
        ),
        Product(
            description = "Thumbnail Design",
            rate = 22.3f,
            quantity = 1
        ),
    ),
    signatureUrl = "https://i.ibb.co/JqN6cFN/download.png"
)
