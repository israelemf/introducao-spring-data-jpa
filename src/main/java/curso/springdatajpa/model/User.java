package curso.springdatajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    // Uma entidade precisa de um atributo único (unique), informamos ao banco com a anotação @Id;
    @Id
    // Anotação que determina a geração automática do atributo no banco de dados;
    // IDENTITY = Avisa ao banco para que é necessário um ID correspondente a cada linha inserida na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Anotação que determina o nome da coluna no banco de dados, como também outras informações, como not null, tamanho máximo, etc;
    @Column(name = "user_id")
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String username;
    @Column(length = 50, nullable = false)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
