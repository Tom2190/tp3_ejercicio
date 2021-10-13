package com.example.ejercicio.repository

import com.example.ejercicio.entities.Jugador

class EquipoFutbolRepository {

    var jugadoresList : MutableList<Jugador> = mutableListOf()

    fun getEquipo () : MutableList<Jugador> {
        jugadoresList.add(Jugador("Thiago Alcántara", "Liverpool", "6",
            "https://strikers.futbol/__export/1601420345489/sites/strikers/img/2020/09/29/thiago_alcantara.jpg_1339246181.jpg"))
        jugadoresList.add(Jugador("Steven Gerrard", "Liverpool", "8",
            "https://www.eluniverso.com/resizer/fsJoMMhVCE_MSF8Rg1f0BMyXIVU=/480x360/smart/filters:quality(70)/cloudfront-us-east-1.images.arcpublishing.com/eluniverso/E4W6RHJKH5D7NFYW5UT2LLUY74.jpg"))
        jugadoresList.add(Jugador("Virgil Van Dijk", "Liverpool", "4",
            "https://i0.wp.com/naciondeportes.com/wp-content/uploads/2019/04/Van-Dijk-no-sabe-co%CC%81mo-detendra%CC%81-a-Messi.jpg?fit=1000%2C600&ssl=1"))
        jugadoresList.add(Jugador("Mohamed Salah", "Liverpool", "11",
            "https://cnnespanol.cnn.com/wp-content/uploads/2021/05/GettyImages-1232769290-e1620850776943.jpg?quality=100&strip=info&w=414&h=311&crop=1"))
        jugadoresList.add(Jugador("Roberto Firmino", "Liverpool", "9",
            "https://s.hs-data.com/bilder/spieler/gross/178325.jpg"))
        jugadoresList.add(Jugador("Sadio Mané", "Liverpool", "10",
            "https://www.cadena3.com/admin/playerswf/fotos/ARCHI_577079.jpg"))
        jugadoresList.add(Jugador("Alisson Becker", "Liverpool", "1",
            "https://s.hs-data.com/bilder/spieler/gross/248681.jpg"))
        jugadoresList.add(Jugador("Andrew Robertson", "Liverpool", "26",
            "https://as01.epimg.net/futbol/imagenes/2020/09/17/primera/1600340555_706149_1600340753_noticia_normal_recorte1.jpg"))
        jugadoresList.add(Jugador("Trent Alexander-Arnold", "Liverpool", "66",
            "https://acefootball.com/es/wp-content/uploads/sites/3/2020/10/GettyImages-1257641596.jpg"))
        jugadoresList.add(Jugador("Fabinho", "Liverpool", "3",
            "https://depor.com/resizer/WOooxUt_V-inS2BC5jqojgQrREc=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/L36M2RLF2VFGZOPOY7QRXCO4V4.jpg"))

        return jugadoresList
    }
}