<md>PROYECTO DE PRUEBA</md>
<p>El objetivo del proyecto es el de programar un servicio web en el que se tiene una lista de 4 clubes que cuentan con clientes, a su vez dichos clientes pueden contar con autos, el objetivo es el de especificar un club al consumir el servicio y que se retornen los chips de autos que se encuentren activos en el club especificado. El proyecto cuenta con las siguientes características:</p>

- `El proyecto usa el framework Spring Boot`
- `El proyecto hace uso de Hibernate`
- `Las relaciones entre tablas se mapean con hibernate`
- `Las tablas se crean a partir de POJO`
```
@Entity
@Table(name = "automovil")
public class AutomovilModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutomovil;
    
    @Column(name = "color")
    private String color;

    @Column(name = "placas")
    private String placas;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private ClienteModelo idCliente;

    @Column(name = "id_chip")
    private Long idChip;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "activo")
    private int activo;
}
```
<p>En el bloque de código se puede observar el uso de Hibernate para declarar la tabla además de que también se está usando para mapear la relación con otra tabla, además de que se usan clases simples sin involucrar a un framework en especial, haciendo que las tablas se crearan a partir de los POJO, características que se pueden observar con las otras entidades de igual manera </p>

- `Manejo de piscinas de conexiones`
```
spring.application.name=servicio
spring.datasource.url=jdbc:mysql://localhost:3306/alpha
spring.datasource.username=ADMIN
spring.datasource.password=Chabeleitor777
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=10
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.pool-name=HikariConnPool
```
<p>En el presente bloque de código perteneciente a las propiedades del proyecto se puede observar como se hace uso de piscinas de conexiones, en especifico con Hikari, ya que de igual forma se puede hacer uso de piscinas de conexiones con Tomcat, de igual forma se tiene que especificar en el pom.xml que se usará Hikari</p>

```
<dependency>
	<groupId>com.zaxxer</groupId>
	<artifactId>HikariCP</artifactId>
</dependency>
```

- `El proyecto hace uso de streams de datos`
```
@Transactional
    public ArrayList<Long> buscarChips(Long idClub){
        Stream<AutomovilModelo> automovilesActivos = automovilRepository.findByIdCliente_Club_IdClubAndIdCliente_ActivoAndActivo(idClub, 1, 1);
        ArrayList<Long> chipsFinales = new ArrayList<Long>();
        automovilesActivos.forEach((automovil)->{
            chipsFinales.add(automovil.getIdChip());
        });
        return chipsFinales;
    }
```
<p>A su vez se hace uso de stream de datos en los que la lista de automóviles se manejan de esa forma en lugar de ser una lista de arreglos. Para el correcto funcionamiento de los stream de datos se debe especificar que es un proceso transaccional para poder consumir el propio stream de datos.</p>

<p>Los bloques de código representan puntos en específico que representan las características mencionadas sin embargo, en el código fuente se puede observar mas ocasiones en las que se muestran dichas características</p>