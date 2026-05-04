class Insumo:
    def __init__(self, quantidade, mes_validade):
        self.__nome = "Amendoim"
        self.__quantidade = quantidade
        self.__mes_validade = mes_validade

    def esta_valido(self, mes_atual):
        if self.__mes_validade < mes_atual:
            print("ALERTA: Risco de Amendoim Murcho! Produto Vencido")
            return False
        return True

    def exibir_info(self):
        print("\n--- Dados do Insumo ---")
        print("Nome:", self.__nome)
        print("Quantidade:", self.__quantidade)
        print("Mês de validade:", self.__mes_validade)

def ler_mes(mensagem):
    while True:
        try:
            mes = int(input(mensagem))
            if 1 <= mes <= 12:
                return mes
            else:
                print("ERRO: Digite um mês entre 1 e 12.")
        except ValueError:
            print("ERRO: Digite apenas números.")

if __name__ == "__main__":
    print("Cadastro de Amendoim 🥜")

    quantidade = int(input("Digite a quantidade: "))

    mes_validade = ler_mes("Digite o mês de validade (1-12): ")

    amendoim = Insumo(quantidade, mes_validade)

    amendoim.exibir_info()

    mes_atual = ler_mes("\nDigite o mês atual (1-12): ")

    if amendoim.esta_valido(mes_atual):
        print("Amendoim dentro da validade.")
    else:
        print("Amendoim não pode ser utilizado.")