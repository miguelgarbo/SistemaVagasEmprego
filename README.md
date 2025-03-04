/VAGAS DE EMPREGO
sistema será projetado para gerenciar o cadastro de empresas, vagas de emprego,
candidatos e o processo de aplicação para as vagas, sem a necessidade de banco de
dados. O sistema permitirá que as empresas publiquem vagas, candidatos se inscrevam
para as vagas e o sistema gerencie as inscrições de forma simples e eficiente.
O sistema contará com funcionalidades como o cadastro de empresas, publicação de
vagas de emprego, inscrição de candidatos para vagas e a visualização das vagas
disponíveis. O cadastro de empresas permitirá registrar informações sobre a empresa,
como nome, setor e localidade. As empresas poderão publicar as vagas disponíveis,
informando requisitos, descrição da vaga, salário e benefícios. Os candidatos poderão se
inscrever nas vagas, informando seu nome, experiência e área de interesse. Além disso, o
sistema permitirá que as empresas visualizem as inscrições para as vagas e possam
selecionar os candidatos.
O sistema será desenvolvido utilizando Programação Orientada a Objetos (POO) para
garantir modularidade, flexibilidade e escalabilidade. Herança será utilizada para que
diferentes tipos de usuários, como empresas e candidatos, compartilhem características
comuns, como nome, email e telefone. Polimorfismo será aplicado para que diferentes
tipos de usuários, como Empresa e Candidato, tenham comportamentos específicos ao
visualizar ou cadastrar informações, por exemplo. Composição será empregada na classe
Vaga, que terá uma lista de objetos Candidato, representando todos os candidatos
inscritos para a vaga. Interfaces serão usadas para padronizar as operações de inscrição e
visualização de vagas. A classe Usuario será definida como abstrata, com atributos e
métodos comuns para empresas e candidatos, enquanto as classes filhas terão atributos
e comportamentos específicos.
A estrutura básica do sistema incluirá a classe Usuario, que será abstrata e terá atributos
como nome, email e telefone. As classes filhas, como Empresa e Candidato, herdarão de
Usuario e terão atributos específicos, como a descrição da empresa ou as áreas de
interesse do candidato. A interface Vaga definirá os métodos necessários para criar e
visualizar vagas. A classe Vaga implementará essa interface e terá um método para
permitir que os candidatos se inscrevam. A classe GestaoVagas será responsável por
gerenciar as vagas e os candidatos inscritos, permitindo a visualização das vagas abertas,
o gerenciamento das inscrições e a seleção de candidatos.
