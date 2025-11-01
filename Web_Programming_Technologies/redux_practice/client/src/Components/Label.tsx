interface LabelProps{
    cn : string,
    children : string,
    inpFor : string
}

export default function Label(props : LabelProps){
    const {cn, children, inpFor} = props;
    return <label className={cn} htmlFor={inpFor}>{children}</label>
}