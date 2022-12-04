package com.example.aplikasiobengkel.data.local

import com.example.aplikasiobengkel.R
import com.example.aplikasiobengkel.utils.Strings
import com.example.aplikasiobengkel.data.model.*

object Data {

    //DataCollection - Map
    fun getMenuCategory() : Map<String, Menu> {
        return mapOf(
            REPAIR_MENU to Menu(
                thumbnail = R.drawable.ic_baseline_build_24,
                title = Strings.get(R.string.repair_service)
            ) ,
            CRANE_MENU to Menu(
                thumbnail = R.drawable.ic_baseline_construction_24,
                title = Strings.get(R.string.crane_service)
            ),
            PROFILE_MENU to Menu(
                thumbnail = R.drawable.ic_baseline_person_24,
                title = Strings.get(R.string.profile_menu)
            ),
            CHAT_MENU to Menu(
                thumbnail = R.drawable.ic_baseline_chat_24,
                title = Strings.get(R.string.chat_menu)
            ),
            HISTORY_MENU to Menu(
                thumbnail = R.drawable.ic_baseline_reorder_24,
                title = Strings.get(R.string.history_menu)
            ),
            PROMO_MENU to Menu(
                thumbnail = R.drawable.img,
                title = Strings.get(R.string.promo_menu)
            ),
        )
    }

    fun getProfileCategory() : Map<String, Profile>{
        return mapOf(
            CHANGE_PROFILE_MENU to Profile(
                thumbnail = R.drawable.ic_baseline_profile_edit,
                title = Strings.get(R.string.profile_edit)
            ),
            TERM_CONDITIONS_MENU to Profile(
                thumbnail = R.drawable.ic_baseline_term_condition,
                title = Strings.get(R.string.term_condition)
            ),
            PRIVACY_POLICY_MENU to Profile(
                thumbnail = R.drawable.ic_baseline_privacy_policy,
                title = Strings.get(R.string.privacy_policy)
            ),
            CONTACT_US_MENU to Profile(
                thumbnail = R.drawable.ic_baseline_contact_us,
                title = Strings.get(R.string.contact_us)
            )
        )

    }

    //DataCollection - List
    fun getDataMechanic() : List<Mechanic> {
        return listOf(
            Mechanic(
                name = "Montir Mulyadi",
                location = "Area Balikpapan",
                age = "25 Tahun",
                rate = "100%"
            ),
            Mechanic(
                name = "Montir Azmy",
                location = "Area Jatinangor Dan Bandung",
                age = "25 Tahun",
                rate = "100%"
            ),
            Mechanic(
                name = "Montir Ancha",
                location = "Area Jatinangor Dan Bandung",
                age = "25 Tahun",
                rate = "100%"
            ),
            Mechanic(
                name = "Montir Riswan",
                location = "Area Jatinangor Dan Bandung",
                age = "25 Tahun",
                rate = "100%"
            ),
            Mechanic(
                name = "Montir Aziz",
                location = "Area Jatinangor Dan Bandung",
                age = "25 Tahun",
                rate = "100%"
            ),
            Mechanic(
                name = "Montir Yuda",
                location = "Area Jatinangor Dan Bandung",
                age = "25 Tahun",
                rate = "100%"
            ),
            Mechanic(
                name = "Montir Shaubari",
                location = "Area Jatinangor Dan Bandung",
                age = "25 Tahun",
                rate = "100%"
            ),
        )
    }

    fun getDataServiceStation() : List<ServiceStation> {
        return listOf(
            ServiceStation(
                name = "Bengkel Santoso",
                location = "Area Balikpapan",
                price = "250000"
            ),
            ServiceStation(
                name = "Joyokusumo Towing",
                location = "Area Balikpapan",
                price = "250000"
            ),
            ServiceStation(
                name = "Maju Jaya Solo",
                location = "Area Balikpapan",
                price = "250000"
            ),
            ServiceStation(
                name = "Bengkel Iskandar",
                location = "Area Balikpapan",
                price = "250000"
            ),
            ServiceStation(
                name = "Jaya Tarigan Bengkel",
                location = "Area Balikpapan",
                price = "250000"
            ),
            ServiceStation(
                name = "Bengkel Sinar Akmal",
                location = "Area Balikpapan",
                price = "250000"
            ),
        )
    }

    fun getDataArticle() : List<Article>{
        return listOf(
            Article(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
            Article(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
            Article(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
            Article(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
        )
    }

    fun getDataPromo() : List<Promo>{
        return listOf(
            Promo(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
            Promo(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
            Promo(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
            Promo(
                thumbnail = R.drawable.img_carousel_1,
                title = "Digitalisasi Otomotif"
            ),
        )
    }

    const val REPAIR_MENU = "repair_menu"
    const val CRANE_MENU = "crane_menu"
    const val PROFILE_MENU = "profile_menu"
    const val CHAT_MENU = "chat_menu"
    const val HISTORY_MENU = "history_menu"
    const val PROMO_MENU = "promo_menu"
    const val CHANGE_PROFILE_MENU = "change_profile_menu"
    const val TERM_CONDITIONS_MENU = "term_conditions_menu"
    const val PRIVACY_POLICY_MENU = "privacy_policy_menu"
    const val CONTACT_US_MENU = "contact_us_menu"
}