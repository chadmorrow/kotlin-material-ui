package components.paper

import components.MaterialElementBuilder
import components.consumers
import components.paper.enums.PaperStyle
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import react.RComponent
import react.RProps
import react.RState
import kotlin.reflect.KClass

open class PaperElementBuilder<T: Tag> internal constructor(
    type: RComponent<RProps, RState>,
    tag: KClass<T>,
    factory: (TagConsumer<Unit>) -> T = consumers(tag)
) : MaterialElementBuilder<T>(type, factory) {

    fun Tag.classes(vararg classMap: Pair<PaperStyle, String>) {
        setClasses(classMap.map { it.first.toString() to it.second })
    }
    var Tag.elevation: Number
        get() = @Suppress("UnsafeCastFromDynamic") props.asDynamic()["elevation"]
        set(value) { setProp("elevation", value) }
    var Tag.square: Boolean
        get() = @Suppress("UnsafeCastFromDynamic") props.asDynamic()["square"]
        set(value) { setProp("square", value) }
}