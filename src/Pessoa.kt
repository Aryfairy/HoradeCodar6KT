class Pessoa(val nome: String, val altura: Float) {

    fun isMenorOuIgual15m(): Boolean {
        return altura <= 1.5f
    }


    fun isMaiorQue15m(): Boolean {
        return altura > 1.5f
    }


    fun isEntre15e20m(): Boolean {
        return altura > 1.5f && altura < 2.0f
    }
}
