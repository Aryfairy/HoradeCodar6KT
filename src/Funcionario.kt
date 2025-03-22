class Funcionario(val matricula: Int, val nome: String, val salario: Double) {

    fun salarioAcimaDe1000(): Boolean {
        return salario > 1000.0
    }

    fun salarioAbaixoDe1000(): Boolean {
        return salario < 1000.0
    }

    fun salarioIgualA1000(): Boolean {
        return salario == 1000.0
    }
}