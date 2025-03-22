class Aluno(val nome: String, val nota1: Float, val nota2: Float, val nota3: Float, val nota4: Float) {
    fun media(): Float = (nota1 + nota2 + nota3 + nota4) / 4
    fun situacao(): String = if (media() >= 5) "Aprovado" else "Reprovado"
}
