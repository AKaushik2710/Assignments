interface InputProps{
    type : string,
    placeholder : string,
    ref : React.RefObject<HTMLInputElement | null>,
    cn : string,
    name : string
}

export default function Input(props : InputProps){
    const { type="text", placeholder, ref, cn, name} = props;
    return <input type={type} placeholder={placeholder} ref={ref} className={cn} name={name} />
}