# 3.2 Nível 1: Compreensão e Sintaxe (Básico)
while True:
    try:
        idade = int(input("Digite sua idade: "))
       
        if idade < 0:
            print("Erro: A idade não pode ser negativa.")
        else:
            print(f"Idade cadastrada: {idade}")
            break

    except ValueError:
        print("Erro: Insira apenas números inteiros. Por exemplo: 23")
       
#5 Teste com um exemplo do estoque do Dener

while True:
    try:
        estoque = int(input("Digite a quantidade de produtos no estoque: "))

        if estoque < 0:
            print("Erro: O estoque não pode ser negativo.")
        else:
            print(f"Estoque atualizado com sucesso: {estoque} itens.")
            break

    except ValueError:
        print("Erro: Insira apenas números inteiros para o estoque. Por exemplo: 8")

# 3.3 Nível 2: Implementação com Clean Code (Intermediário)

try:
    with open("log_sistema.txt", "w") as arquivo_log:
        arquivo_log.write("Sistema iniciado com sucesso.\n")
        arquivo_log.write("Usuário autenticado.\n")

    print("Arquivo gravado com sucesso.")

except Exception as erro:
    print("Erro ao manipular o arquivo.")

finally:
    print("Rotina de persistência finalizada, recursos liberados.")

#3.3.1 Nível 3: Anatomia do Erro e Refatoração (Avançado)

try:
    with open("dados_financeiros.json", "r") as arquivo:
        conteudo = arquivo.read()
        print(conteudo)

except FileNotFoundError:
    print("Arquivo não encontrado. Criando arquivo padrão...")

    with open("dados_financeiros.json", "a") as arquivo:
        arquivo.write('{\n    "saldo": 0,\n    "movimentacoes": []\n}')

    print("Arquivo criado com sucesso.")