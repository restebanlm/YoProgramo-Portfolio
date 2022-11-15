export class usuario {
    private id?: number; // Con ? le decimos que no es necesario.
    private nombre_usuario: string;
    private password: string;
    private fecha_creacion: string;

    constructor(nombre_usuario: string, password: string, fecha_creacion: string) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.fecha_creacion = fecha_creacion;
    }

    getNombreUsuario() {
        return this.nombre_usuario;
    }

    getPassword() {
        return this.password;
    }

    getFechaCreacion() {
        return this.fecha_creacion;
    }

    setNombreUsuario(nombre_usuario: string) {
        this.nombre_usuario = nombre_usuario;
    }

    setPassword(password: string) {
        this.password = password;
    }

    setFechaCreacion(fecha_creacion: string) {
        this.fecha_creacion = fecha_creacion;
    }
}