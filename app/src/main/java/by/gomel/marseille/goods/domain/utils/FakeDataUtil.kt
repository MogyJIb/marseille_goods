package by.gomel.marseille.goods.domain.utils

import by.gomel.marseille.goods.data.models.Product
import by.gomel.marseille.goods.data.models.ProductCategory
import by.gomel.marseille.goods.data.models.Service
import by.gomel.marseille.goods.data.models.ServiceCategory


fun fakeServices() = listOf(
        Service(category = ServiceCategory.HAIR,
                name = "Мужская стрижка",
                minPrice = 13.0,
                maxPrice = 20.0),
        Service(category = ServiceCategory.HAIR,
                name = "Женская стрижка",
                minPrice = 17.0,
                maxPrice = 21.0),
        Service(category = ServiceCategory.HAIR,
                name = "Полировка волос",
                minPrice = 29.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.HAIR,
                name = "Окрашивание волос",
                minPrice = 15.0,
                maxPrice = 38.0),
        Service(category = ServiceCategory.HAIR,
                name = "Сложное окрашивание",
                minPrice = 100.0,
                maxPrice = 250.0),
        Service(category = ServiceCategory.HAIR,
                name = "Ботокс",
                minPrice = 41.50,
                maxPrice = 80.0),
        Service(category = ServiceCategory.HAIR,
                name = "Brazilian blowout",
                minPrice = 110.0,
                maxPrice = 170.0),
        Service(category = ServiceCategory.HAIR,
                name = "Лечение волос",
                minPrice = 45.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.HAIR,
                name = "Прическа",
                minPrice = 48.0,
                maxPrice = 60.0),

        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр",
                minPrice = 12.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + лак",
                minPrice = 16.50,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + гельлак",
                minPrice = 28.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + гельлак + френч",
                minPrice = 33.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Снятие гельлака",
                minPrice = 5.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр",
                minPrice = 25.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + лак",
                minPrice = 29.50,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + 1фаза гель",
                minPrice = 33.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + гельлак",
                minPrice = 38.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + гельлак + френч",
                minPrice = 42.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Снятие гельлака",
                minPrice = 5.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.MAKE_UP,
                name = "Консультация",
                minPrice = 20.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Дневной",
                minPrice = 60.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Вечерний",
                minPrice = 60.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Свадебный",
                minPrice = 80.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Мужской",
                minPrice = 45.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Выезд визажиста",
                minPrice = 10.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.MAGIC_WHITE,
                name = "EXPRESS отбеливание зубов",
                minPrice = 55.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAGIC_WHITE,
                name = "COMPLEX отбеливание зубов",
                minPrice = 83.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAGIC_WHITE,
                name = "SUPER отбеливание зубов",
                minPrice = 105.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Маникюрные щипчики",
                minPrice = 7.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Маникюрные ножницы",
                minPrice = 6.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Пушер (шабер)",
                minPrice = 4.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Прямые ножницы",
                minPrice = 7.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Филировочные ножницы",
                minPrice = 7.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Горячие ножницы",
                minPrice = 10.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Ножи для машинки",
                minPrice = 12.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Ножи для мясорубки",
                minPrice = 12.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Опасная бритва (скальпель)",
                minPrice = 6.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Бытовой нож (1 см лезвия)",
                minPrice = 0.30,
                maxPrice = -1.0)
)

fun fakeProducts() = listOf(
        Product(category = ProductCategory.ITALY,
                name = "Energizing blend scalp treatment",
                price = 32.0),
        Product(category = ProductCategory.ITALY,
                name = "Energizing blend shampoo",
                price = 30.0),
        Product(category = ProductCategory.ITALY,
                name = "Purifying blend shampoo",
                price = 28.0),
        Product(category = ProductCategory.ITALY,
                name = "Smoothing cream",
                price = 31.0),
        Product(category = ProductCategory.ITALY,
                name = "Dry shampoo",
                price = 48.0),
        Product(category = ProductCategory.ITALY,
                name = "Volume solution styling",
                price = 32.0),
        Product(category = ProductCategory.ITALY,
                name = "Volume solution conditioner",
                price = 31.0),
        Product(category = ProductCategory.ITALY,
                name = "Volume solution shampoo",
                price = 29.0)
)