package com.homework.uilistshomework


object MockUtil {

    private fun getLikedList() =  listOf(
        Item.WatchedMovie("Игры разума", "Очень умный парень, страдает от шизофрении", R.drawable.mind),
        Item.WatchedMovie("Побег из Шоушенка", "Парень сбегает из тюрьмы", R.drawable.shousheng),
        Item.WatchedMovie("Зеленая миля", "Здоровяка обвиняют в преступлении, которое он не совершал", R.drawable.green_mile),
        Item.WatchedMovie("В джазе только девушки", "Парни передеваются в девушек и влюбляются в Монро", R.drawable.mind),
        Item.WatchedMovie("Список Шиндлера", "Парень спасает много жизней", R.drawable.schindler),
        Item.WatchedMovie("Леон", "Жан Рено в очках и маленькая Натали портман", R.drawable.leon),
        Item.WatchedMovie("Интерстеллар", "Парень отправляется на другие планеты сквозь кротовую нору", R.drawable.interstellar),
        Item.WatchedMovie("Начало", "Парень может перемещаться по чужим снам", R.drawable.inception),
        Item.WatchedMovie("Жизнь прекрасна", "История про мужчину и его сына, попавших в концлагерь", R.drawable.live),
        Item.WatchedMovie("Престиж", "Про фокусников, которые на самом деле два брата", R.drawable.prestige),
        Item.WatchedMovie("Бойцовский клуб", "Парень долго не может уснуть, потом взрывает все", R.drawable.fight_club),
        Item.WatchedMovie("Игра", "Парень разыгрывает своего друга, что бы было интереснее жить", R.drawable.game),
        Item.WatchedMovie("Король лев", "Про львов. Плохих и не очень", R.drawable.lion_king),
        Item.WatchedMovie("Валли", "Парень собирает мусор в далеком будущем", R.drawable.walli),
        Item.WatchedMovie("Господин Никто", "Парень прожил очень большую и интересную жизнь", R.drawable.nobody)
    )

    private fun getUnlikedList()= listOf(
        Item.WatchedMovie("Крупная рыба", "Скучный фильм с Юэном Макгрегором", R.drawable.big_fish),
        Item.WatchedMovie("Меланхолия", "Скучный артхаус с Кирстен Данст", R.drawable.melancholia),
        Item.WatchedMovie("Догвилль", "Скучный фильм с Николь Кидман", R.drawable.dogvill),
        Item.WatchedMovie("Сталкер", "Скучный советский фильм", R.drawable.stalker)
    )

    private val newMovies = listOf(
        "Довод",
        "Паразиты",
        "История игуршек 4",
        "Аватар 2",
        "Век Аделин"
    )

    private val oldMovies = listOf(
        "Унесенные ветром",
        "Ребекка",
        "Головокружение",
        "Птицы",
        "Психо",
        "Один дома",
        "Назад в будущее",
        "Назад в будущее 2",
        "Назад в будущее 3",
        "Крестный отец",
        "Крестный отец 2",
        "Крестный отец 3",
        "Звездные войны 1",
        "Звездные войны 2",
        "Звездные войны 3",
        "Звездные войны 4",
        "Звездные войны 5",
        "Звездные войны 6"
    )

    @ExperimentalStdlibApi
    fun getHeaderMoviesList() = listOf(Item.Header("Новинки кино"))+
            getMoviesNewList(5) +
            Item.Header("Старые фильмы")+
            getMoviesOldList(18)


    @ExperimentalStdlibApi
     fun getMoviesNewList(size: Int = newMovies.size) = buildList(size) {

        for(i in newMovies.indices){
            add(Item.Movie(newMovies[i]))
        }
    }

    @ExperimentalStdlibApi
    fun getMoviesOldList(size: Int = newMovies.size) = buildList(size) {

        for(i in oldMovies.indices){
            add(Item.Movie(oldMovies[i]))
        }
    }

    @ExperimentalStdlibApi
    fun getHeaderWatchedMoviesList() = listOf(Item.Header("Понравившиеся фильмы"))+
            getLikedList() +
            Item.Header("Непонравившиеся фильмы")+
            getUnlikedList()
}