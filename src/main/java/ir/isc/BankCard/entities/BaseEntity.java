package ir.isc.BankCard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The {@code BaseEntity} class represents base entity.
 *
 * @author  Saeed Karimi
 * @see     java.lang.Object#toString()
 * @since   0.0.1
 */
@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * The createTime shows the creation time.
     */
    @Column(name = "CREATE_TIME")
    @CreationTimestamp
    private LocalDateTime createTime;

    /**
     * The updateTime shows the update time.
     */
    @Column(name = "UPDATE_TIME")
    @UpdateTimestamp
    private LocalDateTime updateTime;
}
