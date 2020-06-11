
package com.co.maps.feign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Element {

    public Distance distance;
    public Duration duration;
    public String status;

}
